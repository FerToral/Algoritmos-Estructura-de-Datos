package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x*x + y*y);
    }

    boolean esPar(int n) {
        return n%2==0;
    }

    boolean esBisiesto(int n) {
        return (n % 4 == 0 && n % 100 != 0) || n % 400 == 0;
    }

    int factorialIterativo(int n) {
        int res = 1;
        int i = 0;

        while( n > i){
            i++;
            res*=i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if(n == 0)
            return 1;
         
        return factorialRecursivo(n-1)*n;
    }

    boolean esPrimo(int n) {
        int cont = 0;
        if(n<=1)
            return false;
        for(int i=n;i>=1;i--){
            if(n % i == 0)
                cont++;
        }
        return cont==2;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for(int i=0; i<numeros.length;i++){
            res+=numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {

        for(int i=0; i<numeros.length; i++){
            if(numeros[i] == buscado)
                return i;
        }
        return -1;
    }

    boolean tienePrimo(int[] numeros) {

        for(int i=0; i<numeros.length;i++){
            if(esPrimo(numeros[i]))
                return true;
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for(int i=0; i<numeros.length;i++){
            if(!esPar(numeros[i]))
                return false;
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        for(int i=0; i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        if(esPrefijo(s1, s2.substring(s2.length() - s1.length())))
            return true;
        return false;
    }
}
