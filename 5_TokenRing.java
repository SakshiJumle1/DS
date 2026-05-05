import java.util.*;
class TokenRing {
public static void main(String args[]) {
Scanner scan = new Scanner(System.in);
System.out.print("Enter the number of nodes: ");
int n = scan.nextInt();
int token = 0;
int ch;
 // Display ring structure
System.out.println("\nRing Structure:");
for (int i = 0; i < n; i++) {
System.out.print(i + " -> ");
}
System.out.println("0");
do {
System.out.print("\nEnter Sender Node: ");
int s = scan.nextInt();
System.out.print("Enter Receiver Node: ");
int r = scan.nextInt();
// Validation
if (s < 0 || s >= n || r < 0 || r >= n) {
System.out.println("Invalid sender or receiver.");
continue;
}
System.out.print("Enter Data: ");
int data = scan.nextInt();
// Token Passing
System.out.print("\nToken Passing: ");
for (int i = token; (i % n) != s; i++) {
System.out.print((i % n) + " -> ");
}
System.out.println(s);
// Sender sends data
System.out.println("\nSender " + s + " sending data: " + data);
// Data forwarding
for (int i = (s + 1) % n; i != r; i = (i + 1) % n) {
System.out.println("Data " + data + " forwarded by Node " + i);
}
// Receiver receives data
System.out.println("Receiver " + r + " received data: " + data);
// Token now with sender
token = s;
System.out.print("\nDo you want to send again? "+ "(1 = Yes / 0 = No): ");
ch = scan.nextInt();
} while (ch == 1);
scan.close();
}
}
