
package modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Versions {

    @SerializedName("generation-i")
    @Expose
    private GenerationI generationI;
    @SerializedName("generation-ii")
    @Expose
    private GenerationIi generationIi;
    @SerializedName("generation-iii")
    @Expose
    private GenerationIii generationIii;
    @SerializedName("generation-iv")
    @Expose
    private GenerationIv generationIv;
    @SerializedName("generation-v")
    @Expose
    private GenerationV generationV;
    @SerializedName("generation-vi")
    @Expose
    private GenerationVi generationVi;
    @SerializedName("generation-vii")
    @Expose
    private GenerationVii generationVii;
    @SerializedName("generation-viii")
    @Expose
    private GenerationViii generationViii;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Versions() {
    }

    /**
     * 
     * @param generationV
     * @param generationIii
     * @param generationIv
     * @param generationVii
     * @param generationVi
     * @param generationIi
     * @param generationViii
     * @param generationI
     */
    public Versions(GenerationI generationI, GenerationIi generationIi, GenerationIii generationIii, GenerationIv generationIv, GenerationV generationV, GenerationVi generationVi, GenerationVii generationVii, GenerationViii generationViii) {
        super();
        this.generationI = generationI;
        this.generationIi = generationIi;
        this.generationIii = generationIii;
        this.generationIv = generationIv;
        this.generationV = generationV;
        this.generationVi = generationVi;
        this.generationVii = generationVii;
        this.generationViii = generationViii;
    }

    public GenerationI getGenerationI() {
        return generationI;
    }

    public void setGenerationI(GenerationI generationI) {
        this.generationI = generationI;
    }

    public GenerationIi getGenerationIi() {
        return generationIi;
    }

    public void setGenerationIi(GenerationIi generationIi) {
        this.generationIi = generationIi;
    }

    public GenerationIii getGenerationIii() {
        return generationIii;
    }

    public void setGenerationIii(GenerationIii generationIii) {
        this.generationIii = generationIii;
    }

    public GenerationIv getGenerationIv() {
        return generationIv;
    }

    public void setGenerationIv(GenerationIv generationIv) {
        this.generationIv = generationIv;
    }

    public GenerationV getGenerationV() {
        return generationV;
    }

    public void setGenerationV(GenerationV generationV) {
        this.generationV = generationV;
    }

    public GenerationVi getGenerationVi() {
        return generationVi;
    }

    public void setGenerationVi(GenerationVi generationVi) {
        this.generationVi = generationVi;
    }

    public GenerationVii getGenerationVii() {
        return generationVii;
    }

    public void setGenerationVii(GenerationVii generationVii) {
        this.generationVii = generationVii;
    }

    public GenerationViii getGenerationViii() {
        return generationViii;
    }

    public void setGenerationViii(GenerationViii generationViii) {
        this.generationViii = generationViii;
    }

}
