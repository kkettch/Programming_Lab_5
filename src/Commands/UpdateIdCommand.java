package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;
import Utility.CreatorOfMusicBand;
/**
 * Класс реализует выполнение команды update
 * Обновление элемента коллекции по id
 * @author maria
 */
public class UpdateIdCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;
    public UpdateIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        this.consoleManager = new ConsoleManager();
        new CreatorOfMusicBand(collectionManager);
    }
    public UpdateIdCommand(){}
    @Override
    public String getName() {
        return "update";
    }
    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
    @Override
    public void execute(String arg) {
        if (checkArgument(getArguments())) {
            try {
                int id = Integer.parseInt(getArguments().toString());
                collectionManager.updateElement(collectionManager.findElementById(id), id, collectionManager);
            } catch (NumberFormatException msg) {
                consoleManager.println("Введите id типа данных Integer!");
            }
        }
    }
    @Override
    public boolean checkArgument(Object arguments) {
        if (arguments == null) {
            consoleManager.println("Укажите id, по которому нужно обновить элемент коллекции");
            return false;
        } else {
            return true;
        }
    }
}