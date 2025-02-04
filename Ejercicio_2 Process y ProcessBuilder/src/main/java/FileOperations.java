import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.logging.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileOperations {
    private static final Logger logger = Logger.getLogger(FileOperations.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la dirección de destino: ");
        String destinationPath = scanner.nextLine();

        
        File destinationDir = new File(destinationPath);
        if (!destinationDir.exists()) {
            if (destinationDir.mkdirs()) {
                log("Directorio creado: " + destinationPath);
            } else {
                log("Error al crear el directorio: " + destinationPath);
                return;
            }
        } else {
            log("El directorio ya existe: " + destinationPath);
        }

        
        String[] fileNames = {"file1.txt", "file2.txt", "file3.txt"};
        createFiles(destinationDir, fileNames);

        
        String outputDirPath = destinationPath + File.separator + "output";
        File outputDir = new File(outputDirPath);
        if (!outputDir.exists()) {
            if (outputDir.mkdirs()) {
                log("Directorio de salida creado: " + outputDirPath);
            } else {
                log("Error al crear el directorio de salida: " + outputDirPath);
                return;
            }
        } else {
            log("El directorio de salida ya existe: " + outputDirPath);
        }

        copyFiles(destinationDir, outputDir, fileNames);

       
        String zipFileName = destinationPath + File.separator + "output.zip";
        zipFiles(outputDirPath, zipFileName);

        scanner.close();
    }

    private static void createFiles(File destinationDir, String[] fileNames) {
        for (String fileName : fileNames) {
            File file = new File(destinationDir, fileName);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("Contenido de " + fileName);
                log("Archivo creado: " + file.getAbsolutePath());
            } catch (IOException e) {
                log("Error al crear el archivo: " + file.getAbsolutePath() + " - " + e.getMessage());
            }
        }
    }

    private static void copyFiles(File sourceDir, File destDir, String[] fileNames) {
        for (String fileName : fileNames) {
            File sourceFile = new File(sourceDir, fileName);
            File destFile = new File(destDir, fileName);
            try {
                Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                log("Archivo copiado: " + sourceFile.getAbsolutePath() + " a " + destFile.getAbsolutePath());
            } catch (IOException e) {
                log("Error al copiar el archivo: " + sourceFile.getAbsolutePath() + " - " + e.getMessage());
            }
        }
    }

    private static void zipFiles(String sourceDir, String zipFileName) {
        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            Files.walk(Paths.get(sourceDir)).filter(Files::isRegularFile).forEach(file -> {
                try {
                    ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                    zos.putNextEntry(zipEntry);
                    Files.copy(file, zos);
                    zos.closeEntry();
                    log("Archivo comprimido: " + file.getFileName());
                } catch (IOException e) {
                    log("Error al comprimir el archivo: " + e.getMessage());
                }
            });
            log("Archivo ZIP creado: " + zipFileName);
        } catch (IOException e) {
            log("Error al crear el archivo ZIP: " + e.getMessage());
        }
    }

    private static void log(String message) {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter("file_operations_log.txt", true))) {
            logWriter.println(message);
            System.out.println(message);
        } catch (IOException e) {
            System.err.println("Error al escribir en el log: " + e.getMessage());
        }
    }
}