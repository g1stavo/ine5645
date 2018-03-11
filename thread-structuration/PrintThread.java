class PrintThread extends Thread {
   private int sleepTime;
   public PrintThread(String name) {
      super(name);
      sleepTime = (int) (Math.random() * 5000);
      System.err.println("Name: " + getName() + ";  sleep: " + sleepTime);
   }
   
   public void run() {
      try {
         System.err.println(getName() + " going to sleep");         
         Thread.sleep(sleepTime);
      }
      catch (InterruptedException interruptedException) {
         System.err.println(interruptedException.toString());
      }
      System.err.println(getName() + " done sleeping");
   }
}