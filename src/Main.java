import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lütfen isminizi giriniz :");
        String isim = "";
        isim=sc(isim);
        System.out.println("Lütfen Maaşınızı giriniz : ");
        int maas =0;
        maas = sc(maas);
        System.out.println("Lütfen haftalık Çalışma saatlerinizi giriniz : ");
        int saat =0;
        saat = sc(saat);
        System.out.println("Lütfen İşe başladığınız yılı giriniz : ");
        int yil =0;
        yil = sc(yil);
        Employee employee = new Employee(isim,maas,saat,yil);
        employee.yazdir();

    }
    static int sc(int x){
        Scanner scan = new Scanner(System.in);
        x= scan.nextInt();
        return x;
    }
    static String sc(String y){
        Scanner scan = new Scanner(System.in);
        y= scan.next();
        return y;
    }

}


class Employee{
    String name;
    int maas;
    int saat;
    int yil;
    Employee(String name ,int maas, int saat ,int yil){
        this.name =name;
        this.maas = maas;
        this.yil = yil;
        this.saat = saat;
    }

    public  int tax(){

        if (maas<1000)
        {
            return 0;
        }
        else
        {
            return  (maas*3)/100;
        }


    }
    public  int bonus(){

        if (saat>40)
        {
            return (saat -40)*30;
        }
        else {
            return 0;
        }


    }
    public  int raiseSalary()
    {
        int zam =0;
        int yeniyil =  2024 -yil;
        if(yeniyil<10)
        {
            zam= ( maas*5)/100;
        }
        else if (yeniyil>=20)
        {
            zam=   (maas*10)/100;
        } else
        {
            zam=  (maas*15)/100;
        }
        return zam;

    }
    public void yazdir(){
        int vergi = tax();
        int bonus = bonus();
        int zam = raiseSalary();

        System.out.println("Adı: " + name);
        System.out.println("Maaşı: " +maas);
        System.out.println("Çalışma Saati: " + saat);
        System.out.println("Başlangıç Yılı: " + yil);
        System.out.println("Vergi: " + vergi);
        System.out.println("Bonus: " + bonus);
        System.out.println("Maaş Artışı: " + zam);
        System.out.println("Vergi ve Bonuslar ile Toplam Maaş: " + (maas - vergi + bonus));
        System.out.println("Toplam Maaş: " + (maas - vergi + bonus + zam));
    }
}


