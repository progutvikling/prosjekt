package bll.admin;
import gui.admin.ManageKeywordsPanel;
import gui.admin.ManageKeywordsPanelHandler;

import java.util.ArrayList;
import java.util.List;

import dal.admin.KeywordsStore;


public class ManageKeywordsController implements ManageKeywordsPanelHandler {
    public ManageKeywordsPanel view;
	public KeywordsStore store;
	
	private ArrayList<String> keywords;


    public ManageKeywordsController() {
		store = new KeywordsStore();
		keywords = store.getKeywords();
		view = new ManageKeywordsPanel(this);
    }

    @Override
    public boolean addKeyword(String keyword) {
		if (store.addKeyword(keyword)) {
			keywords.add(keyword);
			return true;
		}
		return false;
    }

    @Override
    public boolean deleteKeyword(String keyword) {
		if (store.deleteKeyword(keyword)) {
			keywords.remove(keyword);
			return true;
		}
		return false;
    }
	
    public ManageKeywordsPanel getView() {
		return view;
    }

	@Override
	public List<String> getKeywords() {
		return keywords;
	}
}
