package HW5;


import java.io.File;


/**2. Доработайте класс Tree и метод print который мы разработали
 * на семинаре. Ваш метод должен распечатать полноценное дерево
 * директорий и файлов относительно корневой директории. */

public class Tree {


    public static void main(String[] args) {

        print(new File("."), "", true); // текущая директория les_sem5

    }

    /**
     * File - Информация о файле и о его директории
     * Indent - отрисовка отступа
     * isLast - указывает, последняя ли директория
     */
    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  "; // рисуем отступ длинной в два пробела
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
//        System.out.println(file.getName()); // возвращаем наименование
        // файла или директории на которую указывает файл
        if (file.isDirectory()) {
            System.out.println(file.getName() + "/");
        } else {
            System.out.println("F" + file.getName());
            return;
        }
        File[] files = file.listFiles(); // вызываем у file метод listFile,
        // для проверки наличия вложенных директорий или файлов, и если он
        // возвращает null, то завершаем цикл
        if (files == null)
            return;
        int subDirTotal = 0;
        int fileTotal = 0; // переменная для проверки количества файлов
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
            } else {
                fileTotal++;
            }
        }
        int subDirCounter = 0;
        int fileCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirCounter == subDirTotal - 1 && fileCounter == fileTotal);
                subDirCounter++;
            } else {
                print(files[i], indent, fileCounter == fileTotal - 1 && subDirCounter == subDirTotal);
                fileCounter++;
            }
        }
    }
}

