package app.model;

import java.util.ArrayList;
import java.util.List;

public class ConfigureCSVSource {
    private String path;
    private Boolean hasLabel = false;
    private List<MappingSelect> mappingSelects;

    public ConfigureCSVSource() {
    }

    public Boolean getHasLabel() {
        return this.hasLabel;
    }

    public void setHasLabel(Boolean hasLabel) {
        this.hasLabel = hasLabel;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<MappingSelect> getMappingSelects() {
        return mappingSelects;
    }

    public void setMappingSelects(List<MappingSelect> mappingSelects) {
        this.mappingSelects = mappingSelects;
    }

    //    public List<String> getSelectedFields() {
//        return Utils.getSelectedExternalsFromMappingSelectList(this.getMappingSelects());
//    }
//
//    public List<String> getSelectedMappings() {
//        return Utils.getSelectedOutputsFromMappingSelectList(this.getMappingSelects());
//    }
    public List<String> getOriginalExternals() {
        List<String> externals = new ArrayList<>();
        for (MappingSelect mappingSelect : mappingSelects) {
            externals.add(mappingSelect.getExternal());
        }
        return externals;
    }

    public List<String> getSelectedExternals() {
        List<String> externals = new ArrayList<>();
        for (MappingSelect mappingSelect : this.mappingSelects) {
            if (mappingSelect.isSelected()) externals.add(mappingSelect.getExternal());
        }
        return externals;
    }
    public List<String> getSelectedOutputs() {
        List<String> externals = new ArrayList<>();
        for (MappingSelect mappingSelect : this.mappingSelects) {
            if (mappingSelect.isSelected()) externals.add(mappingSelect.getOutput());
        }
        return externals;
    }

    public ConfigData getConfigData() {
        return ConfigData.getInstanceFromMappingSelectList(mappingSelects);
    }
}
