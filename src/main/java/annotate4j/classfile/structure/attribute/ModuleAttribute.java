package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.attribute.module.Exports;
import annotate4j.classfile.structure.attribute.module.Opens;
import annotate4j.classfile.structure.attribute.module.Requires;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class ModuleAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short moduleNameIndex;

    @FieldOrder(index = 4)
    private short moduleFlags;

    @FieldOrder(index = 5)
    private short moduleVersionIndex;

    @FieldOrder(index = 6)
    private short requiresCount;

    @FieldOrder(index = 7)
    @ContainerSize(fieldName = "requiresCount")
    private List<Requires> requires;

    @FieldOrder(index = 8)
    private short exportsCount;

    @FieldOrder(index = 9)
    @ContainerSize(fieldName = "exportsCount")
    private List<Exports> exports;

    @FieldOrder(index = 10)
    private short opensCount;

    @FieldOrder(index = 11)
    @ContainerSize(fieldName = "opensCount")
    private List<Opens> opens;


    @FieldOrder(index = 12)
    private short usesCount;

    @FieldOrder(index = 13)
    @ContainerSize(fieldName = "usesCount")
    private List<Short> usesIndex;

    @FieldOrder(index = 14)
    private short providesCount;

    @FieldOrder(index = 15)
    @ContainerSize(fieldName = "providesCount")
    private List<Short> provides;

    public short getModuleNameIndex() {
        return moduleNameIndex;
    }

    public void setModuleNameIndex(short moduleNameIndex) {
        this.moduleNameIndex = moduleNameIndex;
    }

    public short getModuleFlags() {
        return moduleFlags;
    }

    public void setModuleFlags(short moduleFlags) {
        this.moduleFlags = moduleFlags;
    }

    public short getModuleVersionIndex() {
        return moduleVersionIndex;
    }

    public void setModuleVersionIndex(short moduleVersionIndex) {
        this.moduleVersionIndex = moduleVersionIndex;
    }

    public short getRequiresCount() {
        return requiresCount;
    }

    public void setRequiresCount(short requiresCount) {
        this.requiresCount = requiresCount;
    }

    public List<Requires> getRequires() {
        return requires;
    }

    public void setRequires(List<Requires> requires) {
        this.requires = requires;
    }

    public short getExportsCount() {
        return exportsCount;
    }

    public void setExportsCount(short exportsCount) {
        this.exportsCount = exportsCount;
    }

    public List<Exports> getExports() {
        return exports;
    }

    public void setExports(List<Exports> exports) {
        this.exports = exports;
    }

    public short getOpensCount() {
        return opensCount;
    }

    public void setOpensCount(short opensCount) {
        this.opensCount = opensCount;
    }

    public List<Opens> getOpens() {
        return opens;
    }

    public void setOpens(List<Opens> opens) {
        this.opens = opens;
    }

    public short getUsesCount() {
        return usesCount;
    }

    public void setUsesCount(short usesCount) {
        this.usesCount = usesCount;
    }

    public List<Short> getUsesIndex() {
        return usesIndex;
    }

    public void setUsesIndex(List<Short> usesIndex) {
        this.usesIndex = usesIndex;
    }

    public short getProvidesCount() {
        return providesCount;
    }

    public void setProvidesCount(short providesCount) {
        this.providesCount = providesCount;
    }

    public List<Short> getProvides() {
        return provides;
    }

    public void setProvides(List<Short> provides) {
        this.provides = provides;
    }
}
