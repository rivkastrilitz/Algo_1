public class Alis_Bob {

    public static int CoinFlips(){
        long result = 0;
        result = Math.round( Math.random());
        return (int)result;
    }

    public static int AliceGame(){
        return CoinFlips();
    }

    public static int BobGame(){
        return CoinFlips();
    }

    public static boolean GameStrategy1(){
        boolean result = false;
        int AliceResult = AliceGame();
        if (AliceResult > 0)
            result = true;
        return result;
    }

    public static boolean GameStrategy2(){
        boolean result = false;
        int AliceResult = AliceGame();
        int BobResult= BobGame();
        if (AliceResult==1 || BobResult==1)
            result = true;
        return result;
    }

    public static boolean GameStrategy3(){
        boolean result = false;
        int AliceResult = AliceGame();
        int BobResult= BobGame();
        if (AliceResult == BobResult)
            result = true;
        return result;
    }

    public static boolean GameStrategy4(){
        boolean result = false;
        int AliceResult = AliceGame();
        int BobResult= BobGame();
        if (AliceResult == BobResult || BobResult==1-AliceResult )
            result = true;
        return result;
    }






}
