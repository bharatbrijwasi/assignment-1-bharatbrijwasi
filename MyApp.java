import java.util.Scanner;

class Person
{
	Scanner sc = new Scanner(System.in);
	public String First_name;
	public String Last_name;
	public String Phone_number;
	public String Email_id;

	public Person()
	{
		this.First_name = null;
		this.Last_name = null;
		this.Phone_number = null;
		this.Email_id = null;
	}

	public void setDetails()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name: ");
		First_name = sc.nextLine();
		System.out.println("Enter Last Name: ");
		Last_name = sc.nextLine();
		System.out.println("Enter Phone Number: ");
		Phone_number = sc.nextLine();
		System.out.println("Enter Email ID : ");
		Email_id = sc.nextLine();
			
	}
}


class Node
{
	Person p;
	Node next;

	public Node(Person p)
	{
		this.p = p;
		this.next = null;
	}
}


class Operation
{
	Node head;

	public Operation()
	{
		this.head = null;
	}

	public boolean isListEmpty()
	{
		return (head == null);
	}

	public void insertNewRecord()
	{
		Person p = new Person();
		Node newnode = new Node(p);
		
		p.setDetails();
		
		if(isListEmpty())
		{
			head = newnode;
		}

		else
		{
			Node temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
			}

			temp.next = newnode;
		}

	}

	public void getDetails()
	{
		if(isListEmpty())
		{
			System.out.println("List has no Contact");
		}
		else
		{

			Node temp = head;
			while(temp != null)
			{
				System.out.println("First Name: "+temp.p.First_name);
				System.out.println("Last Name: "+temp.p.Last_name);
				System.out.println("Phone Number: "+temp.p.Phone_number);
				System.out.println("Email ID: "+temp.p.Email_id);
				System.out.println("------------------------------");
				temp = temp.next;
			}
		}
	}

	public void countLink()
	{
		if(isListEmpty())
		{
			System.out.println("No Element fount in List");
		}

		else
		{
			int count = 1;
			Node temp = head;
			while(temp != null)
			{
				System.out.println(count+" "+ temp.p.First_name+ " "+ temp.p.Last_name);
				temp = temp.next;
				count++;
			}
		}
	}

	public void deleteNumber()
	{

		Node temp = head;
		Node prev = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Press the Number against the Contact to delete it: ");
		int choice = sc.nextInt();

		if(choice == 1)
		{
			temp = head.next;
			head = null;
			head = temp;
		}
		 
		else
		{
			for(int i = 1; i <= choice-1; i++)
			{
				prev = temp;
				temp = temp.next;
			}
			prev.next = temp.next;
		}
		System.out.println("Record is deleted...");
	}

	public void searchContact()
	{
		System.out.println("you could search for a Contact from thier First Name: ");
		Scanner sc = new Scanner(System.in);
		if(head == null)
		{
			System.out.println("No Record available in List");
		}

		else
		{
			Node temp = head;
			Node prev = null;
			String enterFirstName = sc.nextLine();
			while(temp != null)
			{
				if(temp.p.First_name.equals(enterFirstName))
				{
					System.out.println("------------*-------------*-----------");
					System.out.println("First Name: " +temp.p.First_name);
					System.out.println("Last Name: " +temp.p.Last_name);
					System.out.println("Phone Number: " +temp.p.Phone_number);
					System.out.println("Email ID: " +temp.p.Email_id);
				} 
				temp = temp.next;
			}	
		}
	}		
}

class MyApp
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in); 
		Operation op = new Operation();
		System.out.println("Welcome to DBC's Contact List...");
		System.out.println("press 1 to add a new Contact\npress 2 to view all Contact");
		System.out.println("press 3 to search for a Contact\npress 4 to delete a Contact");
		System.out.println("press 5 to exit program");
		int choice = sc.nextInt();

			switch(choice)
			{
				case 1:
				{	  
					System.out.println("You have chosen to add a new Contact\n==============================");
					System.out.print("Enter How many Number you want add to list: ");
					int n = sc.nextInt();
					for(int i = 1; i <= n; i++)
					{
						System.out.println("Enter details of Person.............. "+ i+ "=========================");
						op.insertNewRecord();
					}

				}
				case 2:
				{ 
					System.out.println("===============================\n----Here are all your Contact----");
					System.out.println("----------*----------*----------*----------");
					op.getDetails();
					break;	
				}

				case 3:
				{ 
					op.countLink();
					op.deleteNumber();
					break;
				}
				case 4:
				{
					System.out.println("Here are all your Contacts\n=====================");
					op.countLink();
					op.searchContact();
					break;
				}
				case 5:
				{
					System.out.println("You Exit from program...!");
					System.exit(0);
				}
			}		
	}
}
