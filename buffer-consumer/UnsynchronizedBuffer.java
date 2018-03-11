public class UnsynchronizedBuffer implements Buffer
{
   private int buffer = -1; // compartilhado pelas threads Produtor e Consumidor

   // coloca o valor no buffer
   public void set( int value )
   {
      System.out.printf( "Producer writes\t%2d", value );
      buffer = value;
   } // fim do método set

   // retorna valor do buffer
   public int get()
   {
      System.out.printf( "Consumer reads\t%2d", buffer );
      return buffer;
   } // fim do método get
} 