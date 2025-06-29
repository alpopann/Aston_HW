package testVehicles;

import transportnieSredstva.Samolet;
import transportnieSredstva.Vertolet;
import transportnieSredstva.Kater;
import transportnieSredstva.Tanker;
import transportnieSredstva.Gruzovik;
import transportnieSredstva.Taksi;

public class testVehicles {
    public static void main(String[] args) {
        Samolet samolet = new Samolet();
        Vertolet vertolet = new Vertolet();
        Kater kater = new Kater();
        Tanker tanker = new Tanker();
        Gruzovik gruzovik = new Gruzovik();
        Taksi taksi = new Taksi();

        System.out.println("=== " + samolet.getName() + " ===");
        System.out.println("Колёс: " + samolet.kolvoKoles());
        samolet.vint();
        samolet.krylia();
        samolet.vozitGruzi();

        System.out.println("\n=== " + vertolet.getName() + " ===");
        System.out.println("Колёс: " + vertolet.kolvoKoles());
        vertolet.vint();
        vertolet.krylia();
        vertolet.vozitGruzi();

        System.out.println("\n=== " + kater.getName() + " ===");
        kater.vint();
        kater.vozitGruzi();

        System.out.println("\n=== " + tanker.getName() + " ===");
        tanker.vint();
        tanker.vozitGruzi();

        System.out.println("\n=== " + gruzovik.getName() + " ===");
        System.out.println("Колёс: " + gruzovik.kolvoKoles());
        gruzovik.vozitGruzi();

        System.out.println("\n=== " + taksi.getName() + " ===");
        System.out.println("Колёс: " + taksi.kolvoKoles());
        taksi.vozitGruzi();
    }
}
