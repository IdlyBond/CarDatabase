package mechanics.processor;

import mechanics.processor.cruds.changer.Updater;
import mechanics.processor.cruds.creator.Creator;
import mechanics.processor.cruds.remover.Remover;
import mechanics.processor.cruds.searcher.Selector;

public interface CRUD extends Creator, Remover, Updater, Selector {

}
