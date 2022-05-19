/*import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;

import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;*/
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class bot extends TelegramLongPollingBot {

    protected bot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotUsername() {
        return "HackingWomanTbot";
    }

    @Override
    public String getBotToken() {
        return "";
    }
    @SneakyThrows
    public static void main(String[] args) {
        bot bot = new bot(new DefaultBotOptions());
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }

    public static String choose(File f) throws FileNotFoundException
    {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for(Scanner sc = new Scanner(f); sc.hasNext(); )
        {
            ++n;
            String line = sc.nextLine();
            if(rand.nextInt(n) == 0)
                result = line;
        }

        return result;
    }
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
              Message message = update.getMessage();
              String chatId = message.getChatId().toString();
        while (true) {
            execute(SendMessage.builder().chatId((chatId)).text(choose(new File("C:\\Users\\timat\\Downloads\\SE-lab4-mainTanya111\\SE-lab4-mainTanya\\SE-lab4-main\\telegaBotForTanya\\src\\main\\compliments"))).build());
            Thread.sleep(Long.parseLong("3600000"));
        }
    }
}
