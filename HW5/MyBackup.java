package HW5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * 1. Написать функцию, создающую резервную копию всех файлов в
 * директории во вновь созданную папку ./backup
 */
public class MyBackup {
    public static void main(String[] args) throws IOException {
        String sourceDirectory = "./";
        String backupDirectory = "./backup";
        createBackup(sourceDirectory, backupDirectory);

    }

    /**
     * Метод по созданию директории
     */
    public static void createBackup(String sourceDirectory, String backupDirectory) throws IOException {
        // создаем папку для резервной копии, если её нет
        File backupDir = new File(backupDirectory);
        if (!backupDir.exists()) {
            backupDir.mkdir(); // Если директории нет, то создаем её
        }

        // получаем список содержащихся файлов в директории
        File sourceDir = new File(sourceDirectory);
        File[] filesToBackup = sourceDir.listFiles(); // список содержания директории

        // копируем каждый файл в папку с резервной копией
        for (File file : filesToBackup) {
            if (file.isFile()) {
                Files.copy(file.toPath(), new File(backupDir.getPath()
                        + "/" + file.getName()).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
