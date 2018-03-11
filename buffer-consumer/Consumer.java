public class Consumer implements Runnable
{ 
   private static Random generator = new Random();
   private Buffer sharedLocation; // referência a objeto compartilhado

   // construtor
   public Consumer( Buffer shared )
   {
      sharedLocation = shared;
   } // fim do construtor Consumer 

   // lê o valor do sharedLocation quatro vezes e soma os valores
   public void run()                                           
   {
      int sum = 0;

      for ( int count = 1; count <= 10; count++ ) 
      {
         // dorme de 0 a 3 segundos, lê o valor do buffer e adiciona a soma
         try 
         {
            Thread.sleep( generator.nextInt( 3000 ) );
            sum += sharedLocation.get();
            System.out.printf( "\t\t\t%2d\n", sum );
         } // fim do try
         // se a thread adormecida é interrompida, imprime rastreamento de pilha 
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // fim do catch
      } // fim do for

      System.out.printf( "\n%s %d.\n%s\n", 
         "Consumer read values totaling", sum, "Terminating Consumer." );
   } // fim do método run
}