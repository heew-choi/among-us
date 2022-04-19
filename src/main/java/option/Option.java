package option;

import option.print.IPrintOption;
import option.compare.CompareOption;

public class Option {
    private IPrintOption printOption;
    private CompareOption compareOption;

    public Option(IPrintOption printOption, CompareOption compareOption) {
        this.printOption = printOption;
        this.compareOption = compareOption;
    }

    public IPrintOption getPrintOption() { return printOption; }
    public CompareOption getCompareOption() { return compareOption; }
}
