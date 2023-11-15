package Application.programming;
import java.util.*;
public class Bank_Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Application_Bank bank=new Application_Bank();
		while(true) {
			System.out.println(" 1.Account Creation\n 2.Withdraw Amount\n 3.Deposit Amount\n 4.Profile Settings\n 5.Display deatils\n 6.Balance Enquiry\n 7.Exit");
			System.out.println("Please enter your choice from the above");
			int ch=sc.nextInt();
			boolean bool=false;
			switch(ch) {
				case 1:bank.create_Acc();
						break;
				case 2:	bank.withdraw();
						break;
				case 3:bank.deposit();
						break;
				case 4:System.out.println("Profile Settings");
						bank.profile_settings();
						break;
				case 5:bank.display();
						break;
				case 6:int bal_enq=bank.bal();
						if(bal_enq!=-1) {
							System.out.println("Balance : "+bal_enq);
						}else {
							System.out.println("=========Please Create your Account============");
						}
						break;
				case 7:bool=true;
						break;
				default:
						System.out.println("Please Enter the correct option/choice");
			}
			if(bool==true) {
				break;
			}
		}
	}
}
class Application_Bank{
	Scanner sc=new Scanner(System.in);
	int savings=100000, age,pin,cpin;
	boolean acc=false;
	String acc_holder_name,bank_name,mobile_num;
	public void create_Acc() {
		System.out.println("Enter the your full name :");
		acc_holder_name=sc.nextLine();
		System.out.println("Enter the user age :");
		age=sc.nextInt();
		System.out.println("Enter the Bank Name :");
		sc.nextLine();
		bank_name=sc.nextLine();
		System.out.println("Enter your Mobile number :");
		mobile_num=sc.nextLine();
		while(mobile_num.length()!=10) {
			System.out.println("Please re-enter your mobile number conatins only 10 digits");
			mobile_num=sc.nextLine();
		}
		System.out.println("Create your pin");
		pin=sc.nextInt();
		System.out.println("Please re-enter your pin");
		cpin=sc.nextInt();
		if(pin!=cpin) {
			System.out.println("Your confirmation PIN is wrong");
			System.out.println("So... please re-create your account");
		}else {
			acc=true;
			System.out.println("====================Bank Account Created====================");
		}
		sc.nextLine();
	}
	public void withdraw() {
		if(acc==true) {
			System.out.println("Enter the amount to be withdraw");
			int withdraw_amt=sc.nextInt();
			System.out.println("Enter your pin :");
			int confirm_pin=sc.nextInt();
			if(confirm_pin==pin) {
				if(withdraw_amt>savings) {
					System.out.println("You have entered more than your savings");
				}else {
					savings=savings-withdraw_amt;
					System.out.println("Your final Balance :"+savings);
				}
			}else {
				System.out.println("You have wrong pin");
			}
		}else {
			System.out.println("Please create you Account");
		}
	}
	public void deposit() {
		if(acc==true) {
			System.out.println("Enter the amount to be deposit :");
			int deposit_amt=sc.nextInt();
			System.out.println("Enter your pin :");
			int confirm_pin=sc.nextInt();
			int chances=3;
			while(true && chances >0) {
				boolean bool=false;
				if(confirm_pin==pin) {
					savings=savings+deposit_amt;
					System.out.println("=============Sucessfully Deposited===========");
					System.out.println("Total Balance in your account : "+savings);
					chances=3;
					bool=true;
				}else {
					if(chances>0) {
						chances--;
						System.out.println("You entered wrong pin and you have left only "+chances+" chances");
						System.out.println("Enter your pin Again :");
						int re_confirm_pin=sc.nextInt();
						confirm_pin=re_confirm_pin;
						
					}
				}
				if(bool==true) {
					break;
				}
			}
		}else {
			System.out.println("Please create your account First");
		}
		
	}
	public void profile_settings() {
		if(acc==true) {
			System.out.println("1.Mobile 2.Change ATM Pin 3.Forgot PIN");
			System.out.println("Please enter your choice from the above ");
			int ch=sc.nextInt();
			switch(ch) {
				case 1:System.out.println("User want's to change the mobile number :");
						System.out.println("Enter your mobile number :");
						sc.nextLine();
						String mobile=sc.nextLine();
						mobile_num=mobile;
						while(mobile_num.length()!=10) {
							System.out.println("Please re-enter your mobile number contains only 10 digits");
							mobile_num=sc.nextLine();
						}
						break;
				case 2:System.out.println("User want's to change the ATM Pin ");
						System.out.println("Enter the ATM PIN :");
						int re_pin=sc.nextInt();
						System.out.println("Re-Enter the ATM PIN :");
						int re_cpin=sc.nextInt();
						if(re_pin!=re_cpin) {
							System.out.println("You have Mis-match the PIN");
						}else {
							pin=re_pin;
							cpin=re_cpin;
						}
						break;
				case 3:System.out.println("Enter your mobile number correctly and you have only 1 chance to enter:");
						sc.nextLine();
						String m_num=sc.nextLine();
						while(m_num.length()!=10) {
							System.out.println("Please re-enter your mobile number conatins only 10 digits");
							m_num=sc.nextLine();
						}
						if(m_num.equals(mobile_num)) {
							System.out.println("Enter your pin :");
							int f_pin=sc.nextInt();
							System.out.println("Re-Enter the ATM PIN :");
							int f_cpin=sc.nextInt();
							if(f_pin!=f_cpin) {
								System.out.println("You have Mis-match the PIN");
							}else {
								pin=f_pin;
								cpin=f_cpin;
							}
						}else {
							System.out.println("User mobile number entered is wrong So...");
							System.out.println("Try Again After sometime");
						}
						
						break;
			}
	
		}else {
			System.out.println("Bank Account has not created for User");
		}
	}
	public void display() {
		if(acc==true) {
			System.out.println("===================Account deatils=================");
			System.out.println("Account Holder Name :"+acc_holder_name);
			System.out.println("Account Holder Age :"+age);
			System.out.println("Account Holder Bank :"+bank_name);
			System.out.println("Account Holder Mobile Number :"+mobile_num);
			System.out.println("Account Holder ATM PIN: "+pin);
		}else {
			System.out.println("Bank Account has not created for user");
		}
	}
	public int bal() {
		if(acc==true) {
			return savings;
		}
		return -1;
	}
}

