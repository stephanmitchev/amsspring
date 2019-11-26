package org.usac.amsspring.model;

/**
 * Represents an address by its parsed components.
 */
public class ParsedAddress
{
    protected String primaryNum;
    protected String secondaryNum;
    protected String ruralRouteNum;
    protected String secondaryUnit;
    protected String firstPreDir;
    protected String secondPreDir;
    protected String firstSuffix;
    protected String secondSuffix;
    protected String firstPostDir;
    protected String secondPostDir;
    protected String primaryName;

    public ParsedAddress(String primaryNum, String secondaryNum, String ruralRouteNum, String secondaryUnit,
                         String firstPreDir, String secondPreDir, String firstSuffix, String secondSuffix,
                         String firstPostDir, String secondPostDir, String primaryName)
    {
        this.primaryNum = primaryNum;
        this.secondaryNum = secondaryNum;
        this.ruralRouteNum = ruralRouteNum;
        this.secondaryUnit = secondaryUnit;
        this.firstPreDir = firstPreDir;
        this.secondPreDir = secondPreDir;
        this.firstSuffix = firstSuffix;
        this.secondSuffix = secondSuffix;
        this.firstPostDir = firstPostDir;
        this.secondPostDir = secondPostDir;
        this.primaryName = primaryName;
    }

    public String getPrimaryNum() {
        return primaryNum;
    }

    public String getSecondaryNum() {
        return secondaryNum;
    }

    public String getRuralRouteNum() {
        return ruralRouteNum;
    }

    public String getSecondaryUnit() {
        return secondaryUnit;
    }

    public String getFirstPreDir() {
        return firstPreDir;
    }

    public String getSecondPreDir() {
        return secondPreDir;
    }

    public String getFirstSuffix() {
        return firstSuffix;
    }

    public String getSecondSuffix() {
        return secondSuffix;
    }

    public String getFirstPostDir() {
        return firstPostDir;
    }

    public String getSecondPostDir() {
        return secondPostDir;
    }

    public String getPrimaryName() {
        return primaryName;
    }
}