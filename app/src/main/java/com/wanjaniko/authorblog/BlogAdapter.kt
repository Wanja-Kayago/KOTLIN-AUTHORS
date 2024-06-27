package com.wanjaniko.authorblog


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.atan

class ArticleAdapter(val articlesList: List<Author>): RecyclerView.Adapter<ArticlesViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.author_list_item, parent, false)
        return ArticlesViewHolder((itemView))
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val article = articlesList[position]
        holder.tvLink.text = article.link
        holder.tvDate.text = article.publishingDate
        holder.tvName.text = article.authorName
        holder.tvTitle.text = article.title
        holder.tvPreview.text = article.preview
        if (article.preview.length > 100) {
            holder.tvPreview.text = "${article.preview.substring(0, 100)}..."
            holder.tvLink.visibility = View.VISIBLE
            holder.tvLink.setOnClickListener {
                if (holder.tvLink.text == "See More") {
                    holder.tvPreview.text = article.preview
                    holder.tvLink.text = "See Less"
                } else {
                    holder.tvPreview.text = "${article.preview.substring(0, 100)}..."
                    holder.tvLink.text = "See More"
                }
            }
        } else {
            holder.tvPreview.text = article.preview
            holder.tvLink.visibility = View.GONE
        }
    }
    override fun getItemCount(): Int {
        return articlesList.size
    }

}
class ArticlesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvName = itemView.findViewById<TextView>(R.id.tvName)
    var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    var tvDate = itemView.findViewById<TextView>(R.id.tvDate)
    var tvPreview = itemView.findViewById<TextView>(R.id.tvPreview)
    var tvLink = itemView.findViewById<TextView>(R.id.tvLink)
}