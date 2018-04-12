package offer.chapter2;

public class ReplaceBlank {

	public String replace(String str) {
		
//		String[] strs = str.split(" "); 
//		StringBuffer temp = new StringBuffer();
//		for (String string : strs) {
//			temp.append(string+"%20");
//		}
//		
//		return temp.toString();
		return str.replaceAll(" ", "%20");
	}
	
	public static void main(String[] args) {
		ReplaceBlank rb = new ReplaceBlank();
		System.out.println(rb.replace("you are good!"));
	}
}
