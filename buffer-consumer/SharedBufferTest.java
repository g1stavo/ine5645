public class SharedBufferTest
{
   public static void main( String[] args )
   {
      // cria novo pool de threads com duas threads
      ExecutorService application = Executors.newFixedThreadPool( 2 );

      // cria UnsynchronizedBuffer para armazenar ints
      Buffer sharedLocation = new UnsynchronizedBuffer();

      System.out.println( "Action\t\tValue\tProduced\tConsumed" );
      System.out.println( "------\t\t-----\t--------\t--------\n" );

      // tenta iniciar as threads produtora e consumidora fornecendo acesso a cada uma
      // a sharedLocation
      try 
      {
         application.execute( new Producer( sharedLocation ) );
         application.execute( new Consumer( sharedLocation ) );
      } // fim do try
      catch ( Exception exception )
      {
         exception.printStackTrace();
      } // fim do catch

      application.shutdown(); // termina aplicativo quando as threads terminam
   } // fim do main
} 