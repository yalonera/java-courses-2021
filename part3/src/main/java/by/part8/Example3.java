package by.part8;

import by.part8.internal.Account;
import by.part8.internal.Image;
import java.net.URL;

public class Example3 {

  public static class ImageHelper {

    public static void save(Image image) {
      // сохранение изображение в файловой системе
    }

    public static int deleteDuplicates() {
      // удалить из файловой системы все дублирующиеся изображения и вернуть количество удаленных
      return 0;
    }

    public static Image setImageAsAccountPicture(Image image, Account account) {
      // запрос к базе данных для сохранения ссылки на это изображение для пользователя
      return null;
    }

    public static Image resize(Image image, int height, int width) {
      // изменение размеров изображения
      return null;
    }

    public static Image invertColors(Image image) {
      // изменить цвета на изображении
      return null;
    }

    public static Image download(URL imageUrl) {
      // загрузка битового массива с изображением с помощью HTTP запроса
      return null;
    }

    // и т.п.
  }
}
