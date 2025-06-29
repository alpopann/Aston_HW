package readwrite;

import java.io.*;

// Пример программы для записи в файл и чтения из него,
// с собственным исключением для обёртки ошибок ввода-вывода
public class ReadWrite {

    // Собственное исключение для ошибок при работе с файлами
    public static class FileOperationException extends Exception {
        public FileOperationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * Записывает строку data в файл filePath.
     */
    public static void writeToFile(String filePath, String data) throws FileOperationException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new FileOperationException("Ошибка при записи в файл: " + filePath, e);
        }
    }

    /**
     * Считывает всё содержимое файла filePath и возвращает его как строку.
     */
    public static String readFromFile(String filePath) throws FileOperationException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new FileOperationException("Ошибка при чтении из файла: " + filePath, e);
        }
        return sb.toString();
    }


}
