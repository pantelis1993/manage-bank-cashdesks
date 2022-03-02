package exe04;

import java.util.*;
class Bank {

    private ArrayList<LinkedList<String>> cashReg;

    Bank(int N){
        cashReg = new ArrayList<>(N);
        for(int i = 0;i<N;i++){
            cashReg.add(new LinkedList<>());
        }
    }

    public void customerEnters(String fullName){
        Random r=new Random();
        int randomDesk = r.nextInt(cashReg.size());
        cashReg.get(randomDesk).add(fullName);
        System.out.println(fullName + " entered to be served by cash desk "+randomDesk);
    }

    public void customerServed(){
        Random r=new Random();
        ArrayList<Integer> notEmpty=new ArrayList<>();
         for(int i = 0;i < cashReg.size();i++)
            if(!cashReg.get(i).isEmpty()){
                notEmpty.add(i);
            }
         if(notEmpty.isEmpty()) {
             System.out.println("No customers.");
         }
         else
         {
         int cashDesk = notEmpty.get(r.nextInt(notEmpty.size()));
           String customer = cashReg.get(cashDesk).pop(); //syndedemeni lista
             System.out.println("The customer "+ customer + " served by desk "+cashDesk);
         }
    }

    @Override
    public String toString() {
        String s = "\n" + "=".repeat(20);
          for(int i=0; i<cashReg.size(); i++) {
              s += "\nCash desk " + i + ": ";
              s += cashReg.get(i).toString();
          }
            s += "\n" + "=".repeat(20) + "\n";
          return s;
    }


}
