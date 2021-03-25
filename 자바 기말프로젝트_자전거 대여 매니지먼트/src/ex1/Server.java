package ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class Server {
	ArrayList<Subscriber> Slist=new ArrayList<Subscriber>();
	ArrayList<Bicycle> list = new ArrayList<Bicycle>();
	HashMap<String,Bicycle> map=new HashMap<String,Bicycle>();
	public Server() {
		new ServerThread().start(); 
	}
	class ServerThread extends Thread{
		@Override
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;
			try {
				listener = new ServerSocket(99);
				while(true) {
					socket = listener.accept();
					System.out.println("클라이언트 연결됨\n");
					new ServiceThread(socket).start();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(listener != null)
					listener.close();
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	class ServiceThread extends Thread{
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		public ServiceThread(Socket socket) { // 클라이언트와 통신할 소켓을 전달받음
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void sort(String n) {
			if(n.equals("1")) {
			Collections.sort(list,new IdComparator());
			}
			if(n.equals("2")) {
				Collections.sort(list,new IdRsort());
				}
			if(n.equals("3")) {
				Collections.sort(list,new FeeComparator());
				}
		}
		@Override
		synchronized public void run()  {
			Thread.yield();
			while(true) {
				try {
					System.out.println("입력받아야함");
					String input=in.readLine();
					System.out.println("클라이언트 "+input+"번 입력");
					if(input.equals("1")) {
						String id=in.readLine();
						String type=in.readLine();
						String name=in.readLine();
						String price=in.readLine();
						int p=Integer.parseInt(price);
						list.add(new Bicycle(id,type,name,p));
						System.out.println(list.size());
					}
					else if(input.equals("2")) {
						String k=in.readLine();
						sort(k);
						int size=list.size();
						String s=Integer.toString(size);
						out.write(size+"\n");
						out.flush();
						for(int i=0;i<list.size();i++) {
							Bicycle b=list.get(i);
							out.write(b.Id+"\n");
							out.write(b.type+"\n");
							out.write(b.name+"\n");
							String p=Integer.toString(b.price);
							out.write(b.price+"\n");
						}
						out.flush();
					}
					else if(input.equals("3")) {
						String num=in.readLine();
						int n=Integer.parseInt(num);
						Bicycle b=list.get(n-1);
						b.Id=in.readLine();
						b.type=in.readLine();
						b.name=in.readLine();
						String p=in.readLine();
						int price=Integer.parseInt(p);
						b.price=price;
					}
					else if(input.equals("4")) {
						String num=in.readLine();
						int n=Integer.parseInt(num);
						list.remove(n-1);
					}
					else if(input.equals("5")) {
						String id=in.readLine();
						String name=in.readLine();
						String pass=in.readLine();
						String rate=in.readLine();
						Slist.add(new Subscriber(id,name,pass,rate));
					}
					else if(input.equals("6")) {
						int size1=Slist.size();
						String s=Integer.toString(size1);
						out.write(size1+"\n");
						out.flush();
						for(int i=0;i<Slist.size();i++) {
							Subscriber s1=Slist.get(i);
							out.write(s1.id+"\n");
							out.write(s1.name+"\n");
							out.write(s1.rate+"\n");
						}
						out.flush();
						
					}
				}catch(IOException e) {
					System.out.println("연결 종료\n");
					break;
				}
					
			}
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}

