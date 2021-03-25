package ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	Scanner scan = new Scanner(System.in);
	private Socket socket =null;
	private BufferedReader in;
	private BufferedWriter out;
	public Client()  {
		setupConnetion();
		try {
			run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setupConnetion()  {
		try {
			/*System.out.println("ip입력");
			String ip=scan.next();
			System.out.println("포트 입력");
			String port=scan.next();
			System.out.println("id입력");
			String id=scan.next();
			System.out.println("pass입력");
			String pass=scan.next();
			out.write(id+"\n");
			out.write(pass+"\n");
			out.close();*/
			socket = new Socket("localhost",99);
			System.out.println("서버연결및 파일 지정에 성공");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void run() throws IOException {
		while(true) {
			System.out.println("0.서버연결 및로그인\n1.대여자전거 데이터 입력 2. 대여자전거 리스트 보기\n3.자전거대여로 정보수정 4.대여자전거 정보삭제\n5.신규가입자 정보입력\n 6.가입자리스트보기\n 7.종료");
			String input=scan.next();
			out.write(input+"\n");
			out.flush();
			if(input.equals("1")) 
			{
				System.out.println("세부사항입력:");
				String id=scan.next();
				String type=scan.next();
				String name=scan.next();
				int price=scan.nextInt();
				String p=Integer.toString(price);
				out.write(id+"\n");
				out.write(type+"\n");
				out.write(name+"\n");
				out.write(p+"\n");
				out.flush();
			}
			if(input.equals("2")) {
				System.out.println("1.id순, 2.id 역순, 3.대여가격순 보기");
				String k=scan.next();
				out.write(k+"\n");
				out.flush();
				String size=in.readLine();
				int s=Integer.parseInt(size);
				System.out.println("번호  자전거Id 모델   대여가입자  대여가격");
				for(int i=0; i<s;i++) {
					String id=in.readLine();
					String type=in.readLine();
					String name=in.readLine();
					String price=in.readLine();
					int p=Integer.parseInt(price);
					System.out.println(i+1+"  "+id+"  "+type+"  "+name+"  "+p);
				}
			}
			else if(input.equals("3")){
				System.out.println("번호선택:");
				int num=scan.nextInt();
				String n=Integer.toString(num);
				out.write(n+"\n");
				out.flush();
				System.out.println("세부사항입력:");
				String id=scan.next();
				String type=scan.next();
				String name=scan.next();
				int price=scan.nextInt();
				String p=Integer.toString(price);
				out.write(id+"\n");
				out.write(type+"\n");
				out.write(name+"\n");
				out.write(p+"\n");
				out.flush();
			}
			else if(input.equals("4")) {
				System.out.println("번호선택:");
				int num=scan.nextInt();
				String n=Integer.toString(num);
				out.write(n+"\n");
				out.flush();
				System.out.println(num+"번째 삭제");
			}
			else if(input.equals("5")) {
				System.out.println("세부사항입력:");
				String id=scan.next();
				String name=scan.next();
				String pass=scan.next();
				String rate=scan.next();
				out.write(id+"\n");
				out.write(name+"\n");
				out.write(pass+"\n");
				out.write(rate+"\n");
				out.flush();
			}
			else if(input.equals("6")) {
				String size=in.readLine();
				int s=Integer.parseInt(size);
				System.out.println("번호  자전거Id 모델   대여가입자  대여가격");
				for(int i=0; i<s;i++) {
					String id=in.readLine();
					String name=in.readLine();
					String rate=in.readLine();
					System.out.println(i+1+"  "+id+"  "+name+"  "+rate);
				}
			}
			
			
		}
	}
	public void ac() throws IOException {
		int size=in.read();
		for(int i=0; i<size;i++) {
			String id=in.readLine();
			String type=in.readLine();
			String name=in.readLine();
			String price=in.readLine();
			int p=Integer.parseInt(price);
			System.out.println(""+i+1+"  "+id+"  "+type+"  "+name+"  "+p);
		}
	}
	public static void main(String[] args) throws IOException {
		new Client();
	}

}

