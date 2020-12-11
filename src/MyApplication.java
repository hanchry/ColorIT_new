import javafx.application.Application;
import javafx.stage.Stage;
import model.ProjectListModel;
import model.ProjectListModelManager;
import view.ViewHandler;

public class MyApplication extends Application {

  @Override public void start(Stage stage) throws Exception {
    ProjectListModel pr = new ProjectListModelManager();
    ViewHandler view = new ViewHandler(pr);
    view.start(stage);
  }
}
