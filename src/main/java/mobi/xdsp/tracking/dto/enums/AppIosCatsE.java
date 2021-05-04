package mobi.xdsp.tracking.dto.enums;

import com.alibaba.fastjson.JSONArray;

/**
 * @author huangyongchao
 * 将媒体APP的用户人群进行标签化 U开头
 */
public enum AppIosCatsE {
    /**
     * 7开头的都是游戏
     * 13开头的都是新闻资讯
     */
    Business(6000),
    Weather(6001),
    Utilities(6002),
    Travel(6003),
    Sports(6004),
    SocialNetworking(6005),
    Reference(6006),
    Productivity(6007),
    Photo_Video(6008),
    News(6009),
    Navigation(6010),
    Music(6011),
    Lifestyle(6012),
    Health_Fitness(6013),
    Games(6014),
    ActionGame(7001),
    AdventureGame(7002),
    ArcadeGame(7003),
    BoardGame(7004),
    CardGame(7005),
    CasinoGame(7006),
    DiceGame(7007),
    EducationalGame(7008),
    FamilyGame(7009),
    KidsGame(7010),
    MusicGame(7011),
    PuzzleGame(7012),
    RacingGame(7013),
    RolePlayingGame(7014),
    SimulationGame(7015),
    SportsGame(7016),
    StrategyGame(7017),
    TriviaGame(7018),
    WordGame(7019),
    Finance(6015),
    Entertainment(6016),
    Education(6017),
    Books(6018),
    Medical(6020),
    Newsstand(6021),
    News_Politics(13001),
    Fashion_Style(13002),
    Home_Garden(13003),
    Outdoors_Nature(13004),
    Sports_Leisure(13005),
    Automotive(13006),
    Arts_Photography(13007),
    Brides_Weddings(13008),
    Business_Investing(13009),
    ChildrensMagazines(13010),
    Computers_Internet(13011),
    Cooking_Food_Drink(13012),
    Crafts_Hobbies(13013),
    Electronics_Audio(13014),
    EntertainmentNews(13015),
    Health_Mind_Body(13017),
    History(13018),
    LiteraryMagazines_Journals(13019),
    MensInterest(13020),
    Movies_Music(13021),
    Parenting_Family(13023),
    Pets(13024),
    Professional_Trade(13025),
    RegionalNews(13026),
    Science(13027),
    Teens(13028),
    Travel_Regional(13029),
    WomensInterestNews(13030),
    Catalogs(6022);

    public int code;

    private AppIosCatsE(int code) {
        this.code = code;
    }

    public static void main(String[] args) {
        JSONArray jsonArray = JSONArray.parseArray("4-21,1-247,1-248,1-249");
        System.out.println(jsonArray.get(0));
    }

}
