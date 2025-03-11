
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class UserDataFileWriterImpl implements UserDataFileWriter {

  @Override
  public void writeUserData(UserData userData) throws IOException {
    FileWriter writer = new FileWriter(userData.getLastName(), true);
    String userDataString = String.join(" ",
        userData.getLastName(),
        userData.getFirstName(),
        userData.getMiddleName(),
        userData.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
        String.valueOf(userData.getPhoneNumber()),
        userData.getGender().toString());
    writer.write(userDataString + "\n");
    writer.close();
    System.out.println("Данные сохранены в файл: " + userData.getLastName());
  }
}
