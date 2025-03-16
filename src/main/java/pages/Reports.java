package pages;

public class Reports {

    public static void main(String[] args) {


        String a = "Shahid";

        String b = "";

        for (int i=a.length()-1; i>=0; i--)
        {
            b= b+a.charAt(i);
        }

        if (a.equals(b))
        {
            System.out.println("Pallindrom");
        }else {
            System.out.println("Not Pallindrom");
        }



//        for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                if (a[i] == a[j]) {
//                    System.out.println(a[i]);
//                }
//            }
//        }

    }
}

//        int largest= Integer.MAX_VALUE;
//
//        for (int i =0; i<a.length; i++)
//        {
//            if(a[i]< largest)
//            {
//                largest=a[i];
//            }
//
//        }
//
//        System.out.println(largest);
//
//    }




