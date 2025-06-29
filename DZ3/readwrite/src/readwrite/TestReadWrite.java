package readwrite;

public class TestReadWrite {
    public static void main(String[] args) {
        String path = "example.txt";
        String content = "Пример записи в файл\nВторая строка";

        try {
            // Запись
            ReadWrite.writeToFile(path, content);
            System.out.println("Запись прошла успешно.");

            // Чтение
            String fileContent = ReadWrite.readFromFile(path);
            System.out.println("Содержимое файла:\n" + fileContent);

        } catch (ReadWrite.FileOperationException e) {
            System.err.println(e.getMessage());
            //e.printStackTrace();
        }

    }
}


