import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest2
{
   public static void main( String[] args )
   {
      // cria novo pool de threads com duas threads
      ExecutorService application = Executors.newFixedThreadPool( 2 );

      // cria SynchronizedBuffer para armazenar ints
      Buffer sharedLocation = new SynchronizedBuffer();

      System.out.printf( "%-40s%s\t\t%s\n%-40s%s\n\n", "Operation", 
         "Buffer", "Occupied", "---------", "------\t\t--------" );

      try // tenta iniciar a produtora e a consumidora
      {
         application.execute( new Producer( sharedLocation ) );
         application.execute( new Consumer( sharedLocation ) );
      } // fim do try
      catch ( Exception exception )
      {
         exception.printStackTrace();
      } // fim do catch

      application.shutdown();
   } // fim de main
} 