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
			/*System.out.println("ip�Է�");
			String ip=scan.next();
			System.out.println("��Ʈ �Է�");
			String port=scan.next();
			System.out.println("id�Է�");
			String id=scan.next();
			System.out.println("pass�Է�");
			String pass=scan.next();
			out.write(id+"\n");
			out.write(pass+"\n");
			out.close();*/
			socket = new Socket("localhost",99);
			System.out.println("��������� ���� ������ ����");
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
			System.out.println("0.�������� �׷α���\n1.�뿩������ ������ �Է� 2. �뿩������ ����Ʈ ����\n3.�����Ŵ뿩�� �������� 4.�뿩������ ��������\n5.�ű԰����� �����Է�\n 6.�����ڸ���Ʈ����\n 7.����");
			String input=scan.next();
			out.write(input+"\n");
			out.flush();
			if(input.equals("1")) 
			{
				System.out.println("���λ����Է�:");
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
				System.out.println("1.id��, 2.id ����, 3.�뿩���ݼ� ����");
				String k=scan.next();
				out.write(k+"\n");
				out.flush();
				String size=in.readLine();
				int s=Integer.parseInt(size);
				System.out.println("��ȣ  ������Id ��   �뿩������  �뿩����");
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
				System.out.println("��ȣ����:");
				int num=scan.nextInt();
				String n=Integer.toString(num);
				out.write(n+"\n");
				out.flush();
				System.out.println("���λ����Է�:");
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
				System.out.println("��ȣ����:");
				int num=scan.nextInt();
				String n=Integer.toString(num);
				out.write(n+"\n");
				out.flush();
				System.out.println(num+"��° ����");
			}
			else if(input.equals("5")) {
				System.out.println("���λ����Է�:");
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
				System.out.println("��ȣ  ������Id ��   �뿩������  �뿩����");
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

