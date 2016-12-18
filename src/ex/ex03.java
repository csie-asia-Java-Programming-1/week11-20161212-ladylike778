package ex;
/*
 * Date: 2016/12/12
 * Author: 105021037  ???
 */
import java.util.*;
public class ex03 {
	public static linklist list;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		char contChar ='Y';
		float v1=0;
		boolean flag=true;
		while(contChar=='Y'||contChar=='y'){
			flag=true;
			System.out.print("Number:");
			try{
				v1=scn.nextFloat();
				if(list==null){
					list=new linklist(v1);
				}else{
					list.addNode(v1);
				}
			}catch(NumberFormatException e){
				System.out.println("please provide correct input");
				continue;
			}catch(Exception e1){
				System.out.println("Error:"+e1.toString());
				continue;
			}
			System.out.println("In order");
			list.showAll(list.root);
			System.out.print("\ncontinue(Y/n)?");
			contChar =scn.next().charAt(0);
		}
		System.out.println("thank you");
		list =null;

	}
}
class linklist{
	public Node root;
	public linklist(float val){
		root =new Node(val);
	}
	public void addNode(float v1){
		Node node=root;
		while(node.next() !=null){
			node =node.next();
		}
		node.addNext(v1);
	}
public void showAll(Node node){
	while(true){
		if(node!=null){
			System.out.print(node.getData()+"\t");
			node=node.next();			
		}else{
			break;
		}
	}
}}
class Node{
	private float data;
	private Node next;
	public Node(float val){
		this.data=val;
		this.next=null;
	}
	public float getData(){
		return this.data;
	}
	public Node next(){
		return this.next;
	}
	public void addNext(float v1){
		this.next =new Node(v1);
	}	
}