package factory;

import java.util.HashMap;

import commands.BackCommand;
import commands.ChangePasswordCommand;
import commands.CreateAdCommand;
import commands.DeleteAccountCommand;
import commands.ExitCommand;
import commands.FilterByBrandCommand;
import commands.FilterByPriceCommand;
import commands.LoginUserCommand;
import commands.LogoutCommand;
import commands.ManageRequestsCommand;
import commands.RegisterCommand;
import commands.RemoveAdCommand;
import commands.RemoveUserCommand;
import commands.SearchUserCommand;
import commands.ShowAdsByUserCommand;
import commands.ShowAllCommand;
import commands.UpdateAdCommand;
import menus.Menu;
import menus.MenuListItem;

public class MenuFactory {

	@SuppressWarnings("serial")
	public static MenuListItem getCommand(String CommandType) {
		switch (CommandType) {
		case "LoginUser":
			return new LoginUserCommand(new HashMap<String, MenuListItem>() {
				{
					put("1", getMenu("UserMenu"));
					put("2", getMenu("AdminMenu"));
				}
			});

		case "Register":
			return new RegisterCommand();
		case "Exit":
			return new ExitCommand();
		case "Back":
			return new BackCommand();
		case "ShowAll":
			return new ShowAllCommand();
		case "FilterByBrand":
			return new FilterByBrandCommand();
		case "FilterByPrice":
			return new FilterByPriceCommand();
		case "CreateAd":
			return new CreateAdCommand();
		case "UpdateAd":
			return new UpdateAdCommand();
		case "RemoveAd":
			return new RemoveAdCommand();
		case "ShowAdsByUser":
			return new ShowAdsByUserCommand();
		case "ChangePassowrd":
			return new ChangePasswordCommand();
		case "DeleteAccount":
			return new DeleteAccountCommand();
		case "Logout":
			return new LogoutCommand();
		case "SearchUser":
			return new SearchUserCommand();
		case "RemoveUser":
			return new RemoveUserCommand();
		case "PendingRequests":
			return new ManageRequestsCommand();
		}

		return null;
	}

	@SuppressWarnings("serial")
	public static Menu getMenu(String MenuType) {
		switch (MenuType) {
		case "MainMenu":
			return new Menu("Main Menu", new HashMap<String, MenuListItem>() {
				{
					put("1", getCommand("LoginUser"));
					put("2", getCommand("Register"));
					put("3", getMenu("AdMenu"));
					put("4", getCommand("Exit"));
				}
			});
		case "AdMenu":
			return new Menu("Browse Ads", new HashMap<String, MenuListItem>() {
				{
					put("1", getCommand("ShowAll"));
					put("2", getCommand("FilterByBrand"));
					put("3", getCommand("FilterByPrice"));
					put("4", getCommand("Back"));
					put("5", getCommand("Exit"));
				}
			});
		case "UserMenu":
			return new Menu("User Menu", new HashMap<String, MenuListItem>() {
				{
					put("1", getCommand("CreateAd"));
					put("2", getCommand("ShowAdsByUser"));
					put("3", getCommand("UpdateAd"));
					put("4", getCommand("RemoveAd"));
					put("5", getMenu("AdMenu"));
					put("6", getCommand("ChangePassowrd"));
					put("7", getCommand("DeleteAccount"));
					put("8", getCommand("Logout"));
					put("9", getCommand("Exit"));
				}
			});

		case "AdminMenu":
			return new Menu("Admin Menu", new HashMap<String, MenuListItem>() {
				{
					put("1", getCommand("SearchUser"));
					put("2", getCommand("RemoveUser"));
					put("3", getMenu("AdMenu"));
					put("4", getCommand("RemoveAd"));
					put("5", getCommand("PendingRequests"));
					put("6", getCommand("ChangePassowrd"));
					put("7", getCommand("DeleteAccount"));
					put("8", getCommand("Logout"));
					put("9", getCommand("Exit"));
				}
			});

		}

		return null;
	}

}
