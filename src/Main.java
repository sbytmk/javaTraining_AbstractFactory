import factory.Factory;
import factory.Link;
import factory.Page;
import factory.Tray;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out
					.println("Usage : java Main class.name.of.ConcreateFactory");
			System.out.println("Exsample1 : java Main listfactory.ListFactory");
			System.out
					.println("Exsample2 : java Main tablefactory.TableFactory");
			System.exit(0);
		}
		Factory factory = Factory.getFactory(args[0]);

		Link asahi = factory.createLink("朝日新聞", "http://www.asahi.com/");
		Link yomiuri = factory.createLink("読売新聞", "http://www.yomiuri.co.jp/");
		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link jp_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.co.jp/");
		Link excite = factory.createLink("Excite", "http://www.excite.co.jp/");
		Link google = factory.createLink("Google", "http://www.google.com/");

		Tray traynews = factory.createTray("新聞");
		traynews.add(asahi);
		traynews.add(yomiuri);

		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(jp_yahoo);

		Tray traysearch = factory.createTray("サーチエンジン");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);

		Page page = factory.createPage("Link Page", "結城　浩");
		page.add(traynews);
		page.add(traysearch);
		page.output();

	}
}
