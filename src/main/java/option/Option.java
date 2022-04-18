package option;

import option.printOption.IPrintOption;
import option.compareOption.CompareOption;

public class Option {
    public IPrintOption printOption;
    public CompareOption compareOption;

    public Option(IPrintOption printOption, CompareOption compareOption) {
        this.printOption = printOption;
        this.compareOption = compareOption;
    }
}
