package fr.fidtec.SnippetsJAVA;

import static fr.fidtec.SnippetsJAVA.enumLANDING_SDT.CLIENT;

public class POC_LANDING_SDT {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Lancement du main");
		Thread.sleep(5000);
		System.out.println(CLIENT.getDomainName() + " = " + enumLANDING_SDT.CLIENT.getSDT());
		System.out.println(enumLANDING_SDT.CLIENT.getDomainName() + " = " + enumLANDING_SDT.CLIENT.getSDT());
	}

}
