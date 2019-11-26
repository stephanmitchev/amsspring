package org.usac.amsspring.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ams")
public class AmsSettings
{
    /** Library name */
    private String sharedLibraryName;

    /** Data Paths */
    private String systemPath;
    private String address1Path;
    private String addrIndexPath;
    private String cityStatePath;
    private String crossRefPath;
    private String elotPath;
    private String elotIndexPath;
    private String lacslinkPath;
    private String dpvPath;
    private String fnsPath;
    private String suitelinkPath;
    private String abrstPath;

    /** Data Flags */
    private boolean elotEnabled;
    private boolean ewsEnabled;
    private boolean dpvEnabled;
    private boolean lacslinkEnabled;
    private boolean suitelinkEnabled;
    private boolean abrstEnabled;
    private boolean systemEnabled;

    public String getSharedLibraryName() {
        return sharedLibraryName;
    }

    public void setSharedLibraryName(String sharedLibraryName) {
        this.sharedLibraryName = sharedLibraryName;
    }

    public String getSystemPath() {
        return systemPath;
    }

    public void setSystemPath(String systemPath) {
        this.systemPath = systemPath;
    }

    public String getAddress1Path() {
        return address1Path;
    }

    public void setAddress1Path(String address1Path) {
        this.address1Path = address1Path;
    }

    public String getAddrIndexPath() {
        return addrIndexPath;
    }

    public void setAddrIndexPath(String addrIndexPath) {
        this.addrIndexPath = addrIndexPath;
    }

    public String getCityStatePath() {
        return cityStatePath;
    }

    public void setCityStatePath(String cityStatePath) {
        this.cityStatePath = cityStatePath;
    }

    public String getCrossRefPath() {
        return crossRefPath;
    }

    public void setCrossRefPath(String crossRefPath) {
        this.crossRefPath = crossRefPath;
    }

    public String getElotPath() {
        return elotPath;
    }

    public void setElotPath(String elotPath) {
        this.elotPath = elotPath;
    }

    public String getElotIndexPath() {
        return elotIndexPath;
    }

    public void setElotIndexPath(String elotIndexPath) {
        this.elotIndexPath = elotIndexPath;
    }

    public String getLacslinkPath() {
        return lacslinkPath;
    }

    public void setLacslinkPath(String lacslinkPath) {
        this.lacslinkPath = lacslinkPath;
    }

    public String getDpvPath() {
        return dpvPath;
    }

    public void setDpvPath(String dpvPath) {
        this.dpvPath = dpvPath;
    }

    public String getFnsPath() {
        return fnsPath;
    }

    public void setFnsPath(String fnsPath) {
        this.fnsPath = fnsPath;
    }

    public String getSuitelinkPath() {
        return suitelinkPath;
    }

    public void setSuitelinkPath(String suitelinkPath) {
        this.suitelinkPath = suitelinkPath;
    }

    public String getAbrstPath() {
        return abrstPath;
    }

    public void setAbrstPath(String abrstPath) {
        this.abrstPath = abrstPath;
    }

    public boolean isElotEnabled() {
        return elotEnabled;
    }

    public void setElotEnabled(boolean elotEnabled) {
        this.elotEnabled = elotEnabled;
    }

    public boolean isEwsEnabled() {
        return ewsEnabled;
    }

    public void setEwsEnabled(boolean ewsEnabled) {
        this.ewsEnabled = ewsEnabled;
    }

    public boolean isDpvEnabled() {
        return dpvEnabled;
    }

    public void setDpvEnabled(boolean dpvEnabled) {
        this.dpvEnabled = dpvEnabled;
    }

    public boolean isLacslinkEnabled() {
        return lacslinkEnabled;
    }

    public void setLacslinkEnabled(boolean lacslinkEnabled) {
        this.lacslinkEnabled = lacslinkEnabled;
    }

    public boolean isSuitelinkEnabled() {
        return suitelinkEnabled;
    }

    public void setSuitelinkEnabled(boolean suitelinkEnabled) {
        this.suitelinkEnabled = suitelinkEnabled;
    }

    public boolean isAbrstEnabled() {
        return abrstEnabled;
    }

    public void setAbrstEnabled(boolean abrstEnabled) {
        this.abrstEnabled = abrstEnabled;
    }

    public boolean isSystemEnabled() {
        return systemEnabled;
    }

    public void setSystemEnabled(boolean systemEnabled) {
        this.systemEnabled = systemEnabled;
    }
}