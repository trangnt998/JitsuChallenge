package seleniumhq.tests;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import seleniumhq.steps.RepositorySteps;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("github")
public class RepositoryTest {
    @Steps
    RepositorySteps repoSteps;

    @Test
    @DisplayName("Print repositories are sorted by date updated desc")
    public void printRepoIsSortedByDateUpdateDesc(){
        repoSteps.getRepositoriesOrderByUpdatedDesc();
        System.out.println(repoSteps.listRepos);
    }

    @Test
    @DisplayName("Print total open issues across all repositories")
    public void printTotalOpenIssues(){
        repoSteps.getRepositoriesOrderByUpdatedDesc();
        int count = repoSteps.getTotalOpenIssues();
        System.out.println("Total open issues: " + count);
    }

    @Test
    @DisplayName("Print repository has the most watchers")
    public void printRepoHasTheMostWatcher(){
        repoSteps.getRepositoriesOrderByUpdatedDesc();
        System.out.println("Repo has the most watcher: " + repoSteps.getRepoHasMostWatcher());
    }
}
