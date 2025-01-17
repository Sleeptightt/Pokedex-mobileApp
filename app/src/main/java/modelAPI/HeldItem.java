
package modelAPI;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeldItem {

    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("version_details")
    @Expose
    private List<VersionDetail> versionDetails = new ArrayList<VersionDetail>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HeldItem() {
    }

    /**
     * 
     * @param item
     * @param versionDetails
     */
    public HeldItem(Item item, List<VersionDetail> versionDetails) {
        super();
        this.item = item;
        this.versionDetails = versionDetails;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<VersionDetail> getVersionDetails() {
        return versionDetails;
    }

    public void setVersionDetails(List<VersionDetail> versionDetails) {
        this.versionDetails = versionDetails;
    }

}
