/*El objetivo es trabajar la sintaxis de java, if/else y funciones, con validaciones sobre fechas
 Ingresar una fecha por teclado:  dd/mm/yyyy (dd int, mm int, yyyy int)
 - validar que dd >=1 && <=31 TENIENDO EN CUENTA EL MES
 - validar que mes >=1 && <=12
 - validar que año >=1900 && <= 2099
Nota:  Ojo, si el año es bisiesto, febrero tiene 29 días.  Informar por consola si la fecha es correcta.
 
[Solucion] -> Lo trabaje con un ingreso unico en formato str que parsee a int luego. 
Tambien podria haber trabajado 3 int
 * */
import java.util.Scanner;

public class Desafio1 {

	public static void main(String[] args) {
		//Obtengo fecha
		int[] fecha = obtenerFechaInt();
		int dd = fecha[0];
		int mm = fecha[1];
		int yyyy = fecha[2];
		
		//La valido con funciones
		if(validarFecha(dd,mm,yyyy)) 
			System.out.println("La fecha es correcta!");
		else 
			System.out.println("La fecha es incorrecta.");
	}
	public static int[] obtenerFechaInt() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese la fecha (dd/mm/aaaa): ");
		String strFecha = teclado.next();
		teclado.close();
		
		String[] fecha = strFecha.split("/");
		int dd = Integer.parseInt(fecha[0]);
		int mm = Integer.parseInt(fecha[1]);
		int yyyy = Integer.parseInt(fecha[2]);
		int[] fechaInt = {dd,mm,yyyy};
		
		return fechaInt;
	}
	public static boolean validarAnio(int yyyy) {
		return (yyyy>=1900 && yyyy<=2099);
	}
	public static boolean validarMes(int mm) {
		return (mm>=1 && mm<=12);
	}
	public static boolean esAnioBisiesto(int yyyy) {
		if(yyyy %4 == 0) {
			if(yyyy %100 == 0) {	
				return yyyy%400 == 0;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	public static boolean validarFecha(int dd, int mm, int yyyy) {
		if(!validarAnio(yyyy)) return false;
		if(!validarMes(mm)) return false;
		
		//Si es bisiesto le agrego un dia a febrero
		int[] diasXMes = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(esAnioBisiesto(yyyy)) diasXMes[1] = 29;
		
		return (dd>0 && dd<=diasXMes[mm-1]);
	}

}
