public class Producer implements Runnable
{
   private static Random generator = new Random();
   private Buffer sharedLocation; // referência a objeto compartilhado

   // construtor
   public Producer( Buffer shared )
   {
       sharedLocation = shared;
   } // fim do construtor Producer

   // armazena os valores de 1 a 10 em sharedLocation
   public void run()                             
   {
      int sum = 0;

      for ( int count = 1; count <= 10; count++ )
      {
         try // dorme de 0 a 3 segundos, então coloca valor em Buffer
         {
            Thread.sleep( generator.nextInt( 3000 ) ); // thread sleep
            sharedLocation.set( count ); // configura valor no buffer
            sum += count; // incrementa soma de valores
            System.out.printf( "\t%2d\n", sum );
         } // fim do try
         // se a thread adormecida é interrompida, imprime rastreamento de pilha 
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // fim do catch
      } // fim do for

      System.out.printf( "\n%s\n%s\n", "Producer done producing.", 
         "Terminating Producer." );
   } // fim do método run
}