
public class SynchronizedBuffer implements Buffer
{
   private int buffer = -1; // compartilhado pelas threads Produtor e Consumidor
   private boolean occupied = false; // contagem de buffers ocupados
   
   // coloca o valor no buffer
   public synchronized void set( int value )
   {
      // enquanto não houver posições vazias, coloca a thread em estado de espera
      while ( occupied )
      {
         // envia informações de thread e de buffer para a saída, então espera
         try 
         {
            System.out.println( "Producer tries to write." );
            displayState( "Buffer full. Producer waits." );
            wait();
         } // fim do try
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // fim do catch
      } // fim do while
        
      buffer = value; // configura novo valor de buffer
        
      // indica que a produtora não pode armazenar outro valor
      // até a consumidora recuperar valor atual de buffer
      occupied = true;                                
        
      displayState( "Producer writes " + buffer );
      
      notify(); // instrui a thread em espera a entrar no estado executável
   } // fim do método set; libera bloqueio em SynchronizedBuffer
    
   // retorna valor do buffer
   public synchronized int get()
   {
      // enquanto os dados não são lidos, coloca thread em estado de espera
      while ( !occupied )
      {
         // envia informações de thread e de buffer para a saída, então espera
         try 
         {
            System.out.println( "Consumer tries to read." );
            displayState( "Buffer empty. Consumer waits." );
            wait();
         } // fim do try
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // fim do catch
      } // fim do while

      // indica que a produtora pode armazenar outro valor
      // porque a consumidora acabou de recuperar o valor do buffer 
      occupied = false;                                

      int readValue = buffer; // armazena valor em buffer
      displayState( "Consumer reads " + readValue );
      
      notify(); // instrui a thread em espera a entrar no estado executável

      return readValue;
   } // fim do método get; libera bloqueio em SynchronizedBuffer
    
   // exibe a operação atual e o estado de buffer
   public void displayState( String operation )
   {
      System.out.printf( "%-40s%d\t\t%b\n\n", operation, buffer, 
         occupied );
   } // fim do método displayState 
} 