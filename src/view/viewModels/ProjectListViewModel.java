package view.viewModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Project;
import model.ProjectListModel;

public class ProjectListViewModel {
    private ObservableList<ProjectViewModel> list;
    private ProjectListModel model;

    public ProjectListViewModel(ProjectListModel model){
        this.model = model;
        this.list = FXCollections.observableArrayList();
        update();
    }
    public void update()
    {
        list.clear();
        for (int i = 0; i < model.projectListSize(); i++)
        {
            list.add(new ProjectViewModel(model.getProject(i)));
        }
    }
    public void remove(Project project)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getProjectTitle().get().equals(project.getTitle()))
            {
                list.remove(i);
                break;
            }
        }
    }
    public ObservableList<ProjectViewModel> getList() {
        return list;
    }
    public void add(Project project)
    {
        list.add(new ProjectViewModel(project));
    }
}