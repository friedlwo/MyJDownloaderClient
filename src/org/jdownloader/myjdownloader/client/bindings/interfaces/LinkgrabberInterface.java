package org.jdownloader.myjdownloader.client.bindings.interfaces;

import java.util.HashMap;

import org.jdownloader.myjdownloader.client.bindings.AddLinksQuery;
import org.jdownloader.myjdownloader.client.bindings.CleanupActionOptions;
import org.jdownloader.myjdownloader.client.bindings.ClientApiNameSpace;
import org.jdownloader.myjdownloader.client.bindings.LinkVariantStorable;
import org.jdownloader.myjdownloader.client.bindings.PriorityStorable;
import org.jdownloader.myjdownloader.client.bindings.UrlDisplayTypeStorable;
import org.jdownloader.myjdownloader.client.bindings.CleanupActionOptions.Action;
import org.jdownloader.myjdownloader.client.bindings.CleanupActionOptions.Mode;
import org.jdownloader.myjdownloader.client.bindings.CleanupActionOptions.SelectionType;
import org.jdownloader.myjdownloader.client.bindings.linkgrabber.CrawledLinkQuery;
import org.jdownloader.myjdownloader.client.bindings.linkgrabber.CrawledLinkStorable;
import org.jdownloader.myjdownloader.client.bindings.linkgrabber.CrawledPackageQuery;
import org.jdownloader.myjdownloader.client.bindings.linkgrabber.CrawledPackageStorable;

@ClientApiNameSpace("linkgrabberv2")
public interface LinkgrabberInterface extends Linkable {

    CrawledPackageStorable[] queryPackages(CrawledPackageQuery queryParams);

    CrawledLinkStorable[] queryLinks(CrawledLinkQuery queryParams);

    void moveToDownloadlist(long[] linkIds, long[] packageIds);

    void removeLinks(long[] linkIds, long[] packageIds);

    void setEnabled(boolean enabled, long[] linkIds, long[] packageIds);

    void renameLink(long linkId, String newName);

    void renamePackage(long packageId, String newName);

    long getChildrenChanged(long structureWatermark);

    String[] getDownloadFolderHistorySelectionBase();

    int getPackageCount();

    void movePackages(long[] packageIds, long afterDestPackageId);

    void moveLinks(long[] linkIds, long afterLinkID, long destPackageID);

    void addLinks(AddLinksQuery query);

    void addContainer(String type, String content);

    LinkVariantStorable[] getVariants(long linkid);

    void setVariant(long linkid, String variantID);

    void addVariantCopy(long linkid, long destinationAfterLinkID, long destinationPackageID, String variantID);

    /**
     * Set the priority for the given link or package ids
     * 
     * @param priority
     * @param linkIds
     * @param packageIds
     */
    void setPriority(PriorityStorable priority, long[] linkIds, long[] packageIds);

    void startOnlineStatusCheck(long[] linkIds, long[] packageIds);

    HashMap<String, Long[]> getDownloadUrls(long[] linkIds, long[] packageIds, UrlDisplayTypeStorable[] urlDisplayTypes);

    void movetoNewPackage(long[] linkIds, long[] pkgIds, String newPkgName, String downloadPath);

    void splitPackageByHoster(long[] linkIds, long[] pkgIds);

    void cleanup(long[] linkIds, long[] packageIds, Action action, Mode mode, SelectionType selectionType);

}
