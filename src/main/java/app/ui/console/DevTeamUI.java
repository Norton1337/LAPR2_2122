package app.ui.console;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class DevTeamUI implements Runnable{

    public DevTeamUI()
    {

    }
    public void run()
    {
        System.out.println("\n");
        System.out.printf("Development Team:\n");
        System.out.printf("\t Nuno Barbosa - 1210822@isep.ipp.pt \n");
        System.out.printf("\t Ana Cruz - 1210802@isep.ipp.pt \n");
        System.out.printf("\t Rafael Martins - 120827@isep.ipp.pt \n");
        System.out.printf("\t Paulo Norton - 120824@isep.ipp.pt \n");
        System.out.printf("\t Rui Gonçalves- 1191831@isep.ipp.pt \n");
        System.out.println("\n");
    }
}
