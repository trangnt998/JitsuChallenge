package seleniumhq.steps;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.*;

public class RepositorySteps {
    private static final String url = "https://api.github.com/orgs/SeleniumHQ";
    public Response response;
    public List<Response> responses = new ArrayList<>();
    public List<Map<String, Object>> listRepos = new ArrayList<>();
    int page = 1;
    int perPage = 100;
    String sort = "updated";
    String direction = "desc";

    @Step("Search and sort the repositories by date updated in descending order")
    public void getRepositoriesOrderByUpdatedDesc(){
        do {
            response = SerenityRest
                .given()
                .header("Accept", "application/vnd.github+json")
                .header("X-GitHub-Api-Version", "2022-11-28")
//                .header("Authorization", "xxx")
                .queryParam("sort", sort)
                .queryParam("direction", direction)
                .queryParam("per_page",perPage)
                .queryParam("page", page)
                .when()
                .get(url + "/repos");
            page ++;
            responses.add(response);

        }while (!response.jsonPath().getList("$").isEmpty());
        for (Response res : responses){
            listRepos.addAll(res.jsonPath().getList("$"));
        }
    }

    @Step("Get total open issues across all repositories")
    public int getTotalOpenIssues(){
        int totalOpenIssues = 0;

        for (int i = 0; i < listRepos.size(); i++){
            Number countOpenIssues = (Number) listRepos.get(i).get("open_issues_count");
            if(countOpenIssues != null){
                totalOpenIssues += countOpenIssues.intValue();
            }
        }
        return totalOpenIssues;
    }


    @Step("Repository has the most watchers")
    public Map<String, Object> getRepoHasMostWatcher(){
            return listRepos
                .stream()
                .max(Comparator.comparingInt(repo -> ((Number) repo.get("watchers_count")).intValue()))
                .orElse(null);

        }
}
