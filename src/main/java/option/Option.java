package option;

import option.print.IPrintOption;
import option.compare.CompareOption;

public class Option {
    public IPrintOption printOption;
    public CompareOption compareOption;

    public Option(IPrintOption printOption, CompareOption compareOption) {
        this.printOption = printOption;
        this.compareOption = compareOption;
    }
}
